import java.util.List;
import javax.swing.JOptionPane;

public class dataController {
    view frame;
    dataimpl impldata;
    
    dataController(view frame){
        this.frame = frame;
        impldata = new dataDAO();
    }
    
    public void tambah(){
        data k = new data();
        k.setJudul(frame.getJtxtjudul().getText());
        k.setGenre(frame.getJtxtgenre().getText());
        k.setPenulis(frame.getJtxtpenulis().getText());
        k.setPenerbit(frame.getJtxtpenerbit().getText());
        k.setLokasi(frame.getJtxtlokasi().getText());
        k.setStock(Integer.parseInt(frame.getJtxtstock().getText()));
        impldata.tambah(k);
    }
    
    public void ubah(){
        data k = new data();
        k.setJudul(frame.getJtxtjudul().getText());
        k.setGenre(frame.getJtxtgenre().getText());
        k.setPenulis(frame.getJtxtpenulis().getText());
        k.setPenerbit(frame.getJtxtpenerbit().getText());
        k.setLokasi(frame.getJtxtlokasi().getText());
        k.setStock(Integer.parseInt(frame.getJtxtstock().getText()));
        impldata.ubah(k);
    }
    
    public void isitabel(){
        
    }
}
