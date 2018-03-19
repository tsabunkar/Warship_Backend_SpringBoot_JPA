package com.example.demo.dto;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.ShipService;

//Writing the customize logic to generate -> auto-increment of
//P.K field from the last/latest Pk value
//GenerationType.AUTO doesnot increment from the last updated
// Pk field number
public class CustomizeIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		// String prefix = "SHIP";
		 Connection connection = session.connection();
		 try {
			 PreparedStatement ps = connection
		                .prepareStatement("SELECT MAX(shipid) AS shipid FROM ship_table");

			 ResultSet rs = ps.executeQuery();
	            if(rs.next())
	            {
	                int id=rs.getInt(1)+1; //first row
	              //  String generatedId = prefix + new Integer(id).toString();
	                System.out.println("Customize Generated Id: " + id);
	                return id;
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

		
		

	        return null;
	}

}
