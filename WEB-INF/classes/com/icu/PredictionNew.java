package com.icu;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PredictionNew {

	public static String Prediction(int day , String str) {
		
		String result="";
		 Statement st1 = null;
	        ResultSet rs1 = null;
	        
	        Statement st = null;
	       
	        String kit = str;//request.getParameter("stock_name");
	        int noofdays = day;//request.getParameter("NoOfDays");
	        try {
	        	Connection conn = DBconnect.getConnect();
	        	
	            String sql = "select * from kithistory where kitid = '" + kit + "' order by date desc limit 3";
	            st1=conn.prepareStatement(sql);
	            
	            long[] datevalues = new long[3];
	            
	            double[]  	spo2Sensorvalues = new double[3];
	            double[] tempvalues = new double[3];
	            double[] vbvalues = new double[3];
	           
	            int count = 0;
	       
	            ResultSet rs = st1.executeQuery(sql);
	            while (rs.next()) {
	               
	            	datevalues[count] = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(rs.getString("date")).getTime();
	                System.out.println();
	                
	                spo2Sensorvalues[count] = Double.parseDouble(rs.getString("spo2Sensor"));
	                tempvalues[count] = Double.parseDouble(rs.getString("temp"));
	                vbvalues[count] = Double.parseDouble(rs.getString("vb"));
	               
	                count++;
	            }

	            double slopespo2 = PredictionAnalysis.slope(spo2Sensorvalues[2], spo2Sensorvalues[0], datevalues[2], datevalues[0]);
	            double slopetemp = PredictionAnalysis.slope(tempvalues[2], tempvalues[0], datevalues[2], datevalues[0]);
	            double slopevb = PredictionAnalysis.slope(vbvalues[2], vbvalues[0], datevalues[2], datevalues[0]);
	         
	            Calendar c = new GregorianCalendar();
	            String sql1 = "SELECT MAX(`date`) as last_date FROM `kithistory` "
	                    + "WHERE `kitid`='" + kit + "';";
	            System.out.println("sql1 "+sql1);
	            
	            st=conn.prepareStatement(sql1);
	            
	            ResultSet last_dates = st.executeQuery(sql1);
	            String date = null;
	            
	            
	            SimpleDateFormat dbDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	            if (last_dates.next()) {
	                date = last_dates.getString(1);
	                System.out.println("last_dates "+date);
	                c.setTime(dbDateFormat.parse(date));//DateFormat.getInstance().parse("2015-04-01"));
	                System.out.println("c "+c.getTime());
	                c.add(Calendar.DATE, noofdays);
	                System.out.println("c add "+c.getTime());
	            }

	            double predictspo2 = PredictionAnalysis.predict(spo2Sensorvalues[0], slopespo2, c.getTimeInMillis(), datevalues[0]);
	            
	            double predicttemp = PredictionAnalysis.predict(tempvalues[0], slopetemp, c.getTimeInMillis(), datevalues[0]);

	         double predictvb = PredictionAnalysis.predict(vbvalues[0], slopevb, c.getTimeInMillis(), datevalues[0]);
	     String predict_date = dbDateFormat.format(c.getTime());
	            System.out.println(" c**** " + predict_date);

//	            sql = "DELETE `predict_stock` "
//	                        + "WHERE stock_date='" + predict_date + "' and stock_name='" + stockname + "';";
//	                System.out.println("line 103 " + sql);
//	                st1 = dbconn.connect();
//	                st1.executeUpdate(sql);
	            
	            //  SELECT `id`, `kid`, `date`, `time`, `temp`, `hum`, `mq2`, `mq5`, `mq135` FROM `airquuality` WHERE 1
	            System.out.println("***********************************");
	            System.out.println(predictspo2);
	            System.out.println(predicttemp);
	            System.out.println(predictvb);
	            System.out.println("***********************************");
	            if((predictspo2>=72 && predictspo2<=80) && (predicttemp>=93 && predicttemp<=99)  && (predictvb>=80 && predictvb<=120)) {
	            	
	            	System.out.println("hiiiiiiiiiiiiiiiiiiiiiiii");
	            	result="1,"+predict_date;
	          	
	            }else {
	            	System.out.println("byyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
	            	result="0,"+predict_date;
	            }
	            
	            
		
	        } catch (Exception ex) {
	            Logger.getLogger(Prediction.class.getName()).log(Level.SEVERE, null, ex);
	        } finally {
	            
	        }
			return result;
			
}}