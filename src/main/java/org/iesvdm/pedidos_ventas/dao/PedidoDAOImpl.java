package org.iesvdm.pedidos_ventas.dao;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.pedidos_ventas.domain.Cliente;
import org.iesvdm.pedidos_ventas.domain.Comercial;
import org.iesvdm.pedidos_ventas.domain.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PedidoDAOImpl implements PedidoDAO<Pedido>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Cliente> findClienteBy(int pedidoId) {

        Cliente cliente = this.jdbcTemplate.queryForObject("""
                            select C.* from pedido P join cliente C on P.id_cliente = C.id and P.id = '' 
                """
                , (rs, rowNum) -> UtilDAO.newCliente(rs), pedidoId
        );

        return null;
    }

    @Override
    public Optional<Comercial> findComercialBy(int pedidoId) {
        return null;
    }

    @Override
    public List<Cliente> getAllClientesByIdPedido(int pedidoId) {

       List<Cliente> clienteList = this.jdbcTemplate.query("""
                select C.* from pedido P join cliente C on P.id_cliente = C.id  
                and P.id = ?
                """, (rs, rowNum) -> UtilDAO.newCliente(rs)
                , pedidoId);

        return clienteList;
    }

    @Override
    public void create(Pedido pedido) {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        //Con recuperación de id generado
        int rows = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("""
                        insert into pedido ( total, fecha, id_cliente, id_comercial)
                        values (?, ?, ?, ?);
                        """, new String[] { "id" });
            int idx = 1;
            ps.setDouble(idx++, pedido.getTotal());
            ps.setDate(idx++, new java.sql.Date(pedido.getFecha().getTime()));
            ps.setInt(idx++, pedido.getCliente().getId());
            ps.setInt(idx++, pedido.getComercial().getId());
            return ps;
        },keyHolder);

        log.info("Filas creadas {}", rows);
        log.debug("Pedido con id = {} grabado correctamente",keyHolder.getKey().intValue());

        pedido.setId(keyHolder.getKey().intValue());

    }

    @Override
    public List<Pedido> getAll() {

        List<Pedido> listPedido = this.jdbcTemplate.query("""
                SELECT * FROM  pedido P left join cliente C on  P.id_cliente = C.id
                                        left join comercial CO on P.id_comercial = CO.id
                """, (rs, rowNum) -> UtilDAO.newPedido(rs)
        );

        return listPedido;
    }

    @Override
    public Optional<Pedido> find(int id) {

        Pedido pedido= this.jdbcTemplate.queryForObject("""
                    select * from pedido P left join cliente C on  P.id_cliente = C.id
                                        left join comercial CO on P.id_comercial = CO.id
                                        WHERE P.id = ?
                """, (rs, rowNum) -> UtilDAO.newPedido(rs), id);

        if (pedido != null) return Optional.of(pedido);
        log.debug("No encontrado pedido con id {} devolviendo Optional.empty()", id);
        return Optional.empty();
    }

    @Override
    public void update(Pedido pedido) {

        this.jdbcTemplate.update("""
                      update pedido set total = ?, fecha = ?, id_cliente = ?, id_comercial = ? where id = ?
                    """, pedido.getTotal(), pedido.getFecha(), pedido.getCliente().getId(), pedido.getComercial().getId(), pedido.getId());

    }

    @Override
    public void delete(long id) {

        this.jdbcTemplate.update("""
                            delete from pedido where id = ? 
                            """
                            , id
        );

    }
}
