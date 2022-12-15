package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class sqlmodelos extends Conexion {

    public boolean registroNotas(MODELO modelo) {
        PreparedStatement ps = null;
        Connection con =  getConnection();
        String sql = "INSERT INTO STIVEN.NOTAS(IDNOTA,TITULO,NOTA,HORA,EVENTO,TIPO_NOTA,VISIBILIDAD,ESTADO,FECHA_REGISTRO,FECHA_MODIFICACION)VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, modelo.getID());
            ps.setString(2, modelo.getTitulo());
            ps.setString(3, modelo.getNota());
            ps.setString(4, modelo.getHora());
            ps.setInt(5, modelo.getEvento());
            ps.setString(6, modelo.getTipoNota());
            ps.setString(7, modelo.getVisibilidad());
            ps.setString(8, modelo.getEstado());
            ps.setString(9, modelo.getFecha_Registro());
            ps.setString(10, modelo.getFecha_Modificacion());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false; //29
        }
    }
}




    

