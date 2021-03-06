/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecosa.daoImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pecosa.connectionFactory.MyBatisConnectionFactory;
import pecosa.dao.ConfirmadosDao;
import pecosa.model.GuardarDistribucion;
import pecosa.model.GuardarProducto;
import pecosa.model.Pecosa;
import pecosa.model.PecosaProductos;
import pecosa.model.ProductosConfirmados;
import pecosa.model.VerificarDistribucion;

/**
 *
 * @author OGPL
 */
public class ConfirmadosDaoImpl implements ConfirmadosDao {

    private SqlSessionFactory sqlSessionFactory;

    public ConfirmadosDaoImpl() {
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    public ConfirmadosDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void actualizarFlac() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Confirmados.update_flac");
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<ProductosConfirmados> getProductosConfirmados() {
        List<ProductosConfirmados> lista = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            lista = session.selectList("Confirmados.getProdConfirm");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("ERROR EN EL IMPL GET PV");
        } finally {
            session.close();
        }
        return lista;
    }

    @Override
    public void guardarDistribucion(GuardarDistribucion p) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Confirmados.guardar_distrib", p);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void actualizarDistribucion(Integer idDis, Integer cantidad) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("idDistrib", idDis);
        map.put("cantidad", cantidad);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Confirmados.update_distrib", map);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public VerificarDistribucion verificarProducto(Integer idDependencia, Integer idNumero) {
        VerificarDistribucion distrib = null;
        System.out.println("ID DEPE: " + idDependencia + " " + "id numero: " + idNumero);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("iddependencia", idDependencia);
        map.put("idnumero", idNumero);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            distrib = session.selectOne("Confirmados.verifDistrib", map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("ERROR EN EL IMPL GET PV");
        } finally {
            session.close();
        }
        return distrib;
    }

    @Override
    public void actualizarDistribucion2(VerificarDistribucion verif) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Confirmados.update_distrib2", verif);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void modificarSBN(String sbn, Integer idNumero) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sbn", sbn);
        map.put("idnumero", idNumero);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Confirmados.update_sbn", map);
            session.commit();
        } finally {
            session.close();
        }
    }

    @Override
    public void guardarPecosa(Pecosa p) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Confirmados.guardar_pecosa", p);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public void guardarProdPecosa(PecosaProductos pp) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Confirmados.guardar_prodpecosa", pp);
            session.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public Integer getIdProductos(GuardarProducto gp) {
        Integer idproductos = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            idproductos = session.selectOne("Confirmados.getIdproducto", gp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR EN Confirmados.getIdproducto");
        } finally {
            session.close();
        }
        return idproductos;
    }

    @Override
    public Integer getIdPecosa(Pecosa p) {
        Integer idpecosa = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            idpecosa = session.selectOne("Confirmados.getIdpecosa", p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR EN Confirmados.getIdpecosa");
        } finally {
            session.close();
        }
        return idpecosa;
    }

    @Override
    public Integer getIdPersona(String nombre) {
        Integer idPersona = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            idPersona = session.selectOne("Confirmados.idPersona", nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR EN Confirmados.idPersona");
        } finally {
            session.close();
        }
        return idPersona;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

}
