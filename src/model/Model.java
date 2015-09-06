package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Model {
	
	private static DBConnection db;
	
	 public static User getUser(String user_id, String password)
	 {
	        User user = null;
	        db = new DBConnection();
	        db.getConnection();
	        try
	        {
	            ResultSet rs;
	            PreparedStatement statement;
	            String query = "SELECT * FROM user WHERE email = '" + user_id + "' AND password = '" + password + "'";
	            statement = db.getConnection().prepareStatement(query);
	            rs = statement.executeQuery();
	            if (rs.next())
	            {
	                user = new User(rs.getString("email"), rs.getString("last_name"), rs.getString("first_name"), rs.getString("cell_no"), rs.getString("address"), rs.getString("password"));
	            }
	            
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return user;
	 }
	 
	 public static User getUser(String user_id)
	 {
	        User user = null;
	        db = new DBConnection();
	        db.getConnection();
	        try
	        {
	            ResultSet rs;
	            PreparedStatement statement;
	            String query = "SELECT * FROM user WHERE email = '" + user_id + "'";
	            statement = db.getConnection().prepareStatement(query);
	            rs = statement.executeQuery();
	            if (rs.next())
	            {
	                user = new User(rs.getString("email"), rs.getString("last_name"), rs.getString("first_name"), rs.getString("cell_no"), rs.getString("address"), rs.getString("password"));
	            }
	            
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return user;
	 }
	 
	 public static void signUpUser(String email, String first_name, String last_name,
				String cell_no, String address, String password)
	 {
	        db = new DBConnection();
	        db.getConnection();
	        try
	        {
	            
	            PreparedStatement statement;
	            String query = "INSERT INTO user(email, first_name, last_name, cell_no, address, password) VALUES('" + email + "','" + first_name  + "','" + last_name + "','" + cell_no + "','" + address + "','" + password +"')";
	            statement = db.getConnection().prepareStatement(query);
	            statement.executeUpdate();
	        }
	        
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	  }
	 
	 public static ArrayList<PlasticOffer> getAllActiveOffers()
	 {
		 	db = new DBConnection();
	        ArrayList<PlasticOffer> list = new ArrayList<PlasticOffer>();
	        try
	        {
	            ResultSet rs;
	            PreparedStatement statement;
	            String query = "SELECT * WHERE status = 'active'";
	            statement = db.getConnection().prepareStatement(query);
	            rs = statement.executeQuery();
	            
	            while(rs.next())
	            {
	            	list.add(new PlasticOffer(rs.getInt("offer_id"), rs.getString("address"), rs.getString("status"), rs.getFloat("kg"), getUser(rs.getString("user_id"))));
	            }
	        }
	        
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return list;
	 }
	 
	 public static void addPlasticOffer(int offer_id, String user_id, float kg, String address, String status)
	 {
		 db = new DBConnection();
		 try
		 {
				String sql = "INSERT INTO plastic_offer (offer_id, user_id, kg, address, status) VALUES (" + offer_id + ",'"  + user_id + "'," + kg +",'" + address + "','" + status + "'";
				PreparedStatement statement = db.getConnection().prepareStatement(sql);
				statement.executeUpdate(sql);
			} 
			catch (Exception e)
			{
				e.getMessage();
			}
	 }
	 
	 public static void addPlasticRequest(int request_id, String address, String status, String offer_id, float kg)
	 {
		 db = new DBConnection();
			try
			{
				String sql = "INSERT INTO plastic_request (request_id, address, status, offer_id, kg) VALUES (" + request_id + ",'"  + address + "','" + status +"'," + offer_id +"," + kg;
				PreparedStatement statement = db.getConnection().prepareStatement(sql);
				statement.executeUpdate(sql);
			} 
			catch (Exception e)
			{
				e.getMessage();
			}
	 }
	 
	 public static void updateRequestStatus (int request_id, String status)
	 {
		 db = new DBConnection();
			try
			{
				String sql = "UPDATE plastic_request SET status = '" + status + "' WHERE request_id = " + request_id + ";";
				PreparedStatement statement = db.getConnection().prepareStatement(sql);
				statement.executeUpdate(sql);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
	 }
	 
	 public static void updateOffer (int offer_id, String status, float kg)
	 {
		 db = new DBConnection();
			try
			{
				String sql = "UPDATE plastic_offer SET status = '" + status + "', kg = " + kg + " WHERE offer_id = '" + offer_id + "';";
				PreparedStatement statement = db.getConnection().prepareStatement(sql);
				statement.executeUpdate(sql);
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
	 }
	 
	 public static void notifyUser (String receiverID, String message)
	 {
		 	db = new DBConnection();
			try
			{
				String sql = "INSERT INTO notification (receiver_id, message) VALUES ('" + receiverID + "','" + message + "';";
				PreparedStatement statement = db.getConnection().prepareStatement(sql);
				statement.executeUpdate(sql);
			} 
			catch (Exception e)
			{
				e.getMessage();
			}
	 }
	 
	 public static ArrayList<Notification> getNotifications(String receiverID)
	 {
	    	ArrayList<Notification> msgs = new ArrayList<Notification>();
	        db = new DBConnection();
	        try
	        {
	            ResultSet rs;
	            PreparedStatement statement;
	            String query = "SELECT * FROM notification WHERE receiver_id = '" + receiverID + "'";
	            statement = db.getConnection().prepareStatement(query);
	            rs = statement.executeQuery();
	            
	            while (rs.next()) {
	            	msgs.add(new Notification(rs.getInt("notification_id"), rs.getString("receiver_id"), rs.getString("message")));
	            		
	            }

	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    	return msgs;
	 }
	
}
