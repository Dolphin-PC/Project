package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class ChatServer {
	public static void main(String[] args){
		try{
			ServerSocket server = new ServerSocket(8008);
			System.out.println("������ ��ٸ��ϴ�.");
			HashMap hm = new HashMap();
			while(true){
				Socket sock = server.accept();
				ChatThread thread = new ChatThread(sock,hm);
				thread.start();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	
}
class ChatThread extends Thread{
	private Socket sock;
	private String id;
	private BufferedReader br;
	private HashMap hm;
	private boolean initFlag = false;
	
	public ChatThread(Socket sock,HashMap hm){
		this.sock = sock;
		this.hm = hm;
		try{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			id = br.readLine();
			
			sendmsg("���� �����߽��ϴ�.");
			System.out.println("������ ������� ���̵�� " + id + "�Դϴ�.");
			
			synchronized(hm){
				hm.put(this.id,pw);
				System.out.println("���� ���������� ���� " + hm.size() + "�Դϴ�.");
			}
			initFlag = true;
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	public void run(){
		try{
			String line = null;
			
			while((line=br.readLine())!=null){
				if(line.equals("/quit"))
					break;
				else
					sendmsg(line);
			}
		}catch(Exception e){
			System.out.println(e);
		}finally{
			synchronized(hm){
				hm.remove(id);
				System.out.println("���� ���������� ���� " + hm.size() + "�Դϴ�.");
			}
			sendmsg(" ���� ���� �����߽��ϴ�.");
		}try{
			if(sock != null)
				sock.close();
		}catch(Exception ex){}
	}
/*	public void broadcast(String msg){
		synchronized(hm){
			Collection collection = hm.values();
			Iterator iter = collection.iterator();
			while(iter.hasNext()){
				PrintWriter pw = (PrintWriter)iter.next();
				pw.println(msg);
				pw.flush();
			}
		}
	}*/

	public void sendmsg(String msg){
		PrintWriter pw;
		try {
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			pw.println(id + ":"+msg);
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}