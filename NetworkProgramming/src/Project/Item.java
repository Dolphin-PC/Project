package Project;

import java.awt.Desktop;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Item{
	public static void main(String[] args) {
		String line = "����";
		String line2 = "��õ��";
		
		for(int i = 0; i < Parser.goodsSearch(line,line2,"â����","�Ѹ����б�","weather").size();i++)
			System.out.println(Parser.goodsSearch(line,line2,"â����","�Ѹ����б�","weather").get(i).getKeyword());
	}
}
