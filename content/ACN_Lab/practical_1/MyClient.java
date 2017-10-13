import java.io.*;
import java.net.*;

public class MyClient{

Socket s;
DataInputStream dis;
DataOutputStream dout;

public MyClient(){

try
{
s=new Socket("localhost",10);
System.out.println(s);
dis=new DataInputStream(s.getInputStream());
dout=new DataOutputStream(s.getOutputStream());
ClientChat();
}
catch(Exception e)
{
System.out.println(e);
}
}

public static void main(String[] str){
  new MyClient();
}

public void ClientChat() throws IOException{

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String s1;

do{

s1=br.readLine();
dout.writeUTF(s1);
dout.flush();
System.out.println("Server Message: "+dis.readUTF());

}
while(!s1.equals("stop"));
}
}

