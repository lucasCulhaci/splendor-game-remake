package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domein.EdelsteenType;
import domein.Ontwikkelingskaart;

public class OntwikkelingskaartMapper {


	public List<Ontwikkelingskaart> maakOntwikkelingskaarten(int niveau){
        try {
            Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
    		conn.createStatement().execute("use ID399875_SDPGroup109");
            PreparedStatement query = conn.prepareStatement("SELECT * FROM Ontwikkelingskaart WHERE niveau = ?");
            List<Ontwikkelingskaart> kaarten = new ArrayList<>();
            query.setInt(1, niveau);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                String typeBonus = rs.getString("typeBonus");
                int prestigePunt = rs.getInt("prestigePunt");
                int onyxen = rs.getInt("onyxen");
                int saffieren = rs.getInt("saffieren");
                int smargden = rs.getInt("smaragden");
                int robijn = rs.getInt("robijn");
                int diamant = rs.getInt("diamant");
                Map<EdelsteenType, Integer> kosten = new HashMap<>();
                if (onyxen != 0) {
                kosten.put(EdelsteenType.ONYX, onyxen);
                }
                if (saffieren != 0) {
                kosten.put(EdelsteenType.SAFFIER, saffieren);
                }
                if (smargden != 0) {
                kosten.put(EdelsteenType.SMARAGD, smargden);
                }
                if (robijn != 0) {
                kosten.put(EdelsteenType.ROBIJN, robijn);
                }
                if (diamant != 0) {
                kosten.put(EdelsteenType.DIAMANT, diamant);
                }
                EdelsteenType type = null;
                if (typeBonus.equals("Black")) {
                	type = EdelsteenType.valueOf("ONYX");
                }
                if (typeBonus.equals("Green")) {
                	type = EdelsteenType.valueOf("SMARAGD");
                }
                if (typeBonus.equals("White")) {
                	type = EdelsteenType.valueOf("DIAMANT");
                }
                if (typeBonus.equals("Blue")) {
                	type = EdelsteenType.valueOf("SAFFIER");
                }
                if (typeBonus.equals("Red")) {
                	type = EdelsteenType.valueOf("ROBIJN");
                }
                
                Ontwikkelingskaart kaart = new Ontwikkelingskaart(kosten, prestigePunt, type, niveau);
                kaarten.add(kaart);
        }
            conn.close();
            return kaarten;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
		
	}
	
	
}

