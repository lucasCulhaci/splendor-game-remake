package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domein.Speler;

public class SpelerMapper {

	private static final String INSERT_SPELER = "insert into Speler (gebruikersNaam, geboorteJaar) values (?, ?)";
	private static final String ZOEK_SPELER = "select * from Speler where gebruikersNaam = ? and geboorteJaar = ?;";

	public void addSpeler(Speler speler){
        try {
            Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
    		conn.createStatement().execute("use ID399875_SDPGroup109");
            PreparedStatement query = conn.prepareStatement(INSERT_SPELER);
			query.setString(1, speler.getGebruikersnaam());
			query.setInt(2, speler.getGeboortejaar());
            query.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

	public boolean zoekSpeler(Speler speler){

        try {
            Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
    		conn.createStatement().execute("use ID399875_SDPGroup109");
            PreparedStatement query = conn.prepareStatement(ZOEK_SPELER);
			query.setString(1, speler.getGebruikersnaam());
			query.setInt(2, speler.getGeboortejaar());
			try (ResultSet rs = query.executeQuery()) {
				return rs.next();
		}

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
