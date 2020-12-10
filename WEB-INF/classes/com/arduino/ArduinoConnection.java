package com.arduino;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import gnu.io.CommPortIdentifier; 
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent; 
import gnu.io.SerialPortEventListener; 
import java.util.Enumeration;


import java.util.Properties;
import javax.sound.midi.MidiDevice.Info;
import com.icu.*;

public class ArduinoConnection implements SerialPortEventListener {
SerialPort serialPort;
    /** The port we're normally going to use. */
private static final String PORT_NAMES[] = {"/dev/tty.usbserial-A9007UX1", // Mac OS X
        "/dev/ttyUSB0", // Linux
        "COM6", // Windows
};

static String id;
static String temp;
static String vibration;
static String ecg;
static String pulse;
static String spo2;
static BufferedReader input;
private static OutputStream output;
private static final int TIME_OUT = 2000;
private static final int DATA_RATE = 9600;
Properties prop = new Properties();
public void initialize() {
	
    CommPortIdentifier portId = null;
    Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

    //First, Find an instance of serial port as set in PORT_NAMES.
    while (portEnum.hasMoreElements()) {
        CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
        for (String portName : PORT_NAMES) {
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
    }
    if (portId == null) {
        System.out.println("Could not find COM port...");
        return;
    }

    try {
        serialPort = (SerialPort) portId.open(this.getClass().getName(),
                TIME_OUT);
        serialPort.setSerialPortParams(DATA_RATE,
                SerialPort.DATABITS_8,
                SerialPort.STOPBITS_1,
                SerialPort.PARITY_NONE);

        // open the streams
        input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
        output = serialPort.getOutputStream();
//        output=serialPort.getOutputBufferSize();

        
       
        
        serialPort.addEventListener(this);
        serialPort.notifyOnDataAvailable(true);
        
        
    } catch (Exception e) {
        System.err.println(e.toString());
    }
}


public synchronized void close() {
    if (serialPort != null) {
        serialPort.removeEventListener();
        serialPort.close();
    }
}

public synchronized void serialEvent(SerialPortEvent oEvent) {
	try
	{
		Thread.sleep(1000);
	}
	catch(Exception e)
	 {
		 System.err.println(e);
		 e.printStackTrace();
	 }
    if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
    	
    	 try {
         
           if(input.ready())
       
           id=input.readLine();
           System.out.println("id = "+id);
           Thread.sleep(1000);
           temp=input.readLine();
           System.out.println("temperature = "+temp);
           Thread.sleep(1000);
           vibration=input.readLine();
           System.out.println("vibration = "+vibration);
           Thread.sleep(1000);
           ecg=input.readLine();
           System.out.println("ecg = "+ecg);
           Thread.sleep(1000);
           pulse=input.readLine();
           System.out.println("pulse = "+pulse);
           Thread.sleep(1000);
           spo2=input.readLine();
           System.out.println("spo2 = "+spo2);
           Thread.sleep(1000);
        
       
        	Connection conn=DBconnect.getConnect();
	 	         
		      
        	PreparedStatement ps = conn.prepareStatement("UPDATE patient SET tempSensor=? , vibrationSensor=? , ECGValue=? , pulseSensor=? , spo2Sensor=? where kit=?");
 	 	      
 	 	        ps.setString(1,temp);
 	 	        ps.setString(2,vibration);
 	 	        ps.setString(3,ecg);
 	 	        ps.setString(4,pulse);
 	 	        ps.setString(5,spo2);
 	 	        ps.setString(6,id);
 	 	
 	 	        ps.executeUpdate();
 	 	        
 	 	        if(Double.parseDouble(temp)>100 || Double.parseDouble(vibration)>400 || Double.parseDouble(pulse)>90 || Double.parseDouble(spo2)>99)
 	 	        {
 	 	        	SendSMS.SMS(id, "7020532164");
 	 	        }
 	   
        	 	
        }
    	 catch(Exception e)
    	 {
    		 System.err.println(e);
    		 e.printStackTrace();
    	 }
           
            
        }
   
    
    }
    

  
    // Ignore all the other eventTypes, but you should consider the other ones.


private Object open(String inputLine, String string) {
	
	// TODO Auto-generated method stub
	return null;
}
public static void main(String[] args) throws SQLException {
	 
	ArduinoConnection main = new ArduinoConnection();
 
    
   main.initialize();
  
        
    Thread t=new Thread() {
        public void run() {
            //the following line will keep this app alive for 1000    seconds,
            //waiting for events to occur and responding to them    (printing incoming messages to console).
            try {Thread.sleep(1000000);} catch (InterruptedException    ie) {}
        }
    };

    
    
   
 
          t.start();
    
    System.out.println("Server Started");
    
    
   
}
}

