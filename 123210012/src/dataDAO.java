import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataDAO implements dataimpl{
    Connection con;
    final String select = "SELECT * FROM dataperpus";
    final String insert = "INSERT INTO dataperpus(judul, genre, penulis, penerbit, lokasi, stock) VALUES(?, ?, ?, ?, ?, ?)";
    final String update = "UPDATE dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";
    final String delete = "DELETE dataperpus set judul=?, genre=?, penulis=?, penerbit=?, lokasi=?, stock=? where id=?";

    public dataDAO(){
        con = koneksi.connection();
    }
    
    @Override
    public void tambah(data k) {
        PreparedStatement st = null;
        try{
            st = con.prepareStatement(insert, st.RETURN_GENERATED_KEYS);
            st.setString(1, k.getJudul());
            st.setString(2, k.getGenre());
            st.setString(3, k.getPenulis());
            st.setString(4, k.getPenerbit());
            st.setString(5, k.getLokasi());
            st.setInt(6, k.getStock());
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                k.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void ubah(data k) {
        PreparedStatement st = null;
        try{
            st = con.prepareStatement(update, st.RETURN_GENERATED_KEYS);
            st.setString(1, k.getJudul());
            st.setString(2, k.getGenre());
            st.setString(3, k.getPenulis());
            st.setString(4, k.getPenerbit());
            st.setString(5, k.getLokasi());
            st.setInt(6, k.getStock());
            ResultSet rs = st.getGeneratedKeys();
            while(rs.next()){
                k.setId(rs.getInt(1));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                st.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void hapus(data k) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<data> getAll() {
        List<data> ks = null;
        try{
            ks = new ArrayList<data>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                data k = new data();
                k.setId(rs.getInt("id"));
                k.setJudul(rs.getString("judul"));
                k.setGenre(rs.getString("genre"));
                k.setPenulis(rs.getString("penulis"));
                k.setPenerbit(rs.getString("penerbit"));
                k.setLokasi(rs.getString("lokasi"));
                k.setStock(rs.getInt("stock"));
                ks.add(k);
            }
        }catch(SQLException ex){
            Logger.getLogger(dataDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return ks;
    }
    
    
}
