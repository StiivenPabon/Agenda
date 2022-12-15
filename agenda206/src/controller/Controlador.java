package controlador;

import Vista.VistaConsulta;
import conexion.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.MODELO;
import modelo.sqlmodelos;
import Vista.VistaNotas;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Controlador implements ActionListener {

    private MODELO modelo;
    private VistaNotas vista;
    private VistaConsulta vistaConsulta;
    Calendar calendarios = Calendar.getInstance();
    Calendar calendario = new GregorianCalendar();

    public Controlador(MODELO modelo, VistaNotas vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnAbrir.addActionListener(this);
        this.vista.btnVaciar.addActionListener(this);
        this.vista.btnGuardado.addActionListener(this);
    }

//    public String Fecha() {
//        int hora, minutos, segundos;
//        hora = calendario.get(Calendar.HOUR_OF_DAY);
//        minutos = calendario.get(Calendar.MINUTE);
//        segundos = calendario.get(Calendar.SECOND);
//        String Fecha_hoy;
//        Fecha_hoy = hora + ":" + minutos + ":" + segundos;
//
//        return Fecha_hoy;
//
//    }
    
        public String FechaRegistro() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return dateFormat.format(date);
    }

    public int ID() {
        Conexion conectar = new Conexion();
        String sql = "SELECT IDNOTA  from NOTAS";

        ResultSet rs = conectar.consultar(sql);
        int id2 = 0;
        try {
            if (rs.equals(null) || rs.equals("")) {
                id2 = 1;
            } else {
                while (rs.next()) {
                    id2 = rs.getInt("IDNOTA");
                }
            }
        } catch (Exception e) {
            System.out.println("error al buscar el int");
        }

        id2++;
        return id2;
    }

    public void eliminar(MODELO modelo) {
        Conexion conectar = new Conexion();
        String sql = "Delete from Notas where IDNOTA=" + modelo.getID() + "";
        conectar.ejecutar(sql);
    }

    public void modificar(MODELO modelo) {
        Conexion conectar = new Conexion();
        String sql = "UPDATE NOTAS SET TITULO='" + modelo.getTitulo() + "',NOTA='" + modelo.getNota() + "', FECHA_MODIFICACION='" + modelo.getFecha_Modificacion() + "' WHERE IDNOTA=" + modelo.getID() + "";
        try {
            conectar.ejecutar(sql);
            JOptionPane.showMessageDialog(null, "Nota modificada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Nota no ha sido modificada" + e);
        }

    }

    public void Abrir() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        if (JFileChooser.APPROVE_OPTION == fileChooser.showOpenDialog(vista)) {
            try {
                File archivo = fileChooser.getSelectedFile();
                FileReader lector = null;

                try {
                    lector = new FileReader(archivo);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }
                BufferedReader bfReader = new BufferedReader(lector);

                String lineaFichero;
                StringBuilder contenidoFichero = new StringBuilder();

                while ((lineaFichero = bfReader.readLine()) != null) {
                    contenidoFichero.append(lineaFichero);
                    contenidoFichero.append("\n");
                }

                // Pone el contenido del fichero en el area de texto
                vista.txtNota.setText(contenidoFichero.toString());

            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

//    public void Guardar(MODELO modelo) {
//
//        sqlmodelos sqlmodelos = new sqlmodelos();
//        Conexion conectar = new Conexion();
//        String sql = "INSERT INTO NOTAS(IDNOTA,TITULO,NOTA,HORA,EVENTO,TIPO_NOTA,VISIBILIDAD,ESTADO,FECHA_REGISTRO,FECHA_MODIFICACION)VALUES(" + modelo.getID() + ",'" + modelo.getTitulo() + "','" + modelo.getNota() + "','" + modelo.getHora() + "',"
//                + null + ",'" + modelo.getTipoNota() + "','" + modelo.getVisibilidad() + "','" + modelo.getEstado() + "','" + modelo.getFecha_Registro() + "'," + null + " )";
//        conectar.ejecutar(sql);
//
//        if (sqlmodelos.registroNotas(modelo)) {
//            JOptionPane.showMessageDialog(null, "Registro guardado con exito ", "", JOptionPane.PLAIN_MESSAGE);
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al guarda tu registro", "error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public void RegistraNotas() {
        sqlmodelos sqlmodelos = new sqlmodelos();

        modelo.setNota(vista.txtNota.getText());
        modelo.setTitulo(vista.txtTitulo.getText());
        modelo.setEvento(Integer.parseInt(vista.txtEvento.getText()));
       

        if (sqlmodelos.registroNotas(modelo)) {
            JOptionPane.showMessageDialog(null, "Registro guardado con exito ", "", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Error al guarda tu registro", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void TablaNotas() {

        try {
            DefaultTableModel modeloTabla = new DefaultTableModel();
            vistaConsulta.tbtNotas.setModel(modeloTabla);

            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConnection();

            String sql = "SELECT IDNOTA , TITULO , NOTA , HORA , EVENTO , TIPO_NOTA ,  VISIBILIDAD , ESTADO , FECHA_REGISTRO , FECHA_MODIFICACION FROM STIVEN.NOTAS";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMd = rs.getMetaData();
            int NumeroColumnas = rsMd.getColumnCount();
            modeloTabla.addColumn("ID");
            modeloTabla.addColumn("TITULO");
            modeloTabla.addColumn("NOTA");
            modeloTabla.addColumn("Hora");
            modeloTabla.addColumn("Evento");
            modeloTabla.addColumn("Tipo Nota");
            modeloTabla.addColumn("Visibilidad");
            modeloTabla.addColumn("Estado");
            modeloTabla.addColumn("Fecha Registro");
            modeloTabla.addColumn("Fecha Modificacion");

            while (rs.next()) {
                Object[] fila = new Object[NumeroColumnas];
                for (int i = 0; i < NumeroColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modeloTabla.addRow(fila);

            }
        } catch (SQLException ex) {
            System.err.println(ex.toString());

        }

    }



    @Override
    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == vista.btnGuardado) {
            RegistraNotas();
            ID();
            FechaRegistro();
//            RegistraNotas();
        }

        if (evt.getSource() == vista.btnConsulta) {
            TablaNotas();
        }

        if (evt.getSource() == vista.btnAbrir) {

            Abrir();
        }
        
        if (evt.getSource() == vistaConsulta.btnModificar){
            
            modificar(modelo);
        }
        
        if (evt.getSource() == vistaConsulta.btnEliminar){
            eliminar(modelo);
        }

        if (evt.getSource() == vista.btnVaciar) {
            System.out.println("Adios");
            vista.txtTitulo.setText("");
            vista.txtNota.setText("");

        }

    }

}
