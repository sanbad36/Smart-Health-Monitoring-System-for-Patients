<%@page import="java.io.*,javax.servlet.*,javax.servlet.http.*" %>
 
<%
String fileName="D://file//sample1.pdf";
File f=new File(fileName);
int length=0;
ServletOutputStream op=response.getOutputStream();
ServletContext context=getServletConfig().getServletContext();
String mimetype=context.getMimeType(fileName);
response.setContentType((mimetype!=null) ? mimetype : "application/octet-stream");
response.setContentLength((int)f.length());
response.setHeader("Content-Disposition","attachment:filename="+fileName);
//complete file downloading using buffering
byte[] bbuf=new byte[1024];
DataInputStream in=new DataInputStream(new FileInputStream(f));
 
while((in!=null)&&((length=in.read(bbuf))!=-1))
{
    op.write(bbuf,0,length);
}
in.close();
op.flush();
op.close();
%>