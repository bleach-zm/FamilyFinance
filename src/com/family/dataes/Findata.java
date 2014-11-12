package com.family.dataes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class Findata { 
	// ���ݿ�����
	private static final String DB_Name = "fimilyfin.db";
	// �����Ͱ汾
	private static final String Consume_types = "consumetypes";
	private static final String Consume_flow = "consumeflow";
	private static final String Consume_kind = "consumekind";
	
	private static final  int 	DB_Version =1;
	//��ṹ
	public static final String Type_Id = "_id";
	public static final String Type_Name = "name";	
	public static final String Type_uptime ="time";
	public static final String Type_parent = "parent_id";
	
	public static final String Kind_id="kindid";
	public static final String Kind_name="kindname";
	
	public static final String Flow_Id="flowid";
	public static final String Flow_value="valueno";
	public static final String Flow_time="flowtime";
	public static final String Flow_com="coomment";
	

	
	//���� sqlitedatabase ���� db
	private SQLiteDatabase findb;
	private final Context context;
	//DBOpenHelper ����SQLiteOpenHelper, ����DBO�����
	//�������������ݿ�
	private DBOpenHelper dbOpenHelper;
	
	 
	//SQLiteOpenHelper ���򿪺ʹ������ݿ�

	private static class DBOpenHelper extends SQLiteOpenHelper { 
		
		public DBOpenHelper(Context contexta, String name1,CursorFactory factory, int version1)
		{
		super(contexta,name1,factory,version1);

		}
		private static final String Create_Type = "create table" + Consume_types +"("+Type_Id+" integer primary key autoincrement, "+ 
			                                      
			Type_Name +" text not null, "+ Kind_id + " text not null, "+ Type_uptime+ Type_parent +");";
		
		private static final String Create_Kind = "create table" + Consume_kind + "(" +Kind_id+" integer primary key autoincrement,"+  
			Kind_name + " text not null,"	+ ");";
		
		private static final String Create_Flow = "create table" +Consume_flow + "(" +Kind_id+" integer primary key autoincrement," + 
			Flow_value + Flow_time + Flow_com + Type_Id + Kind_id + ");";
	
		//insert into  XX select A,B union all select A,B; ��ʼ��  ���� 1=֧�� ��2 = ����
		private static final String Insert_Kind = "insert into" +Consume_kind + "("+Kind_name+")"+ "VALUES" +"("+"֧��"+")," +"("+"����"+");";
		
		//��ʼ���ݣ����ѷ�ʽ
		private static final String Insert_Type = "insert into " + Consume_types +"("+");";
		
	 @Override 
	   public void onCreate(SQLiteDatabase _db) { 
	    _db.execSQL(Create_Type); 
	    _db.execSQL(Create_Kind);
	    _db.execSQL(Create_Flow);
	    _db.execSQL(Insert_Kind);
	  
	    
	} 
	 
	/**
	* 
	* @param _db
	* @param _oldVersion
	* @param _newVersion
	*   
	*/
	 @Override 
	 	public void onUpgrade(SQLiteDatabase _db, int _oldVersion, int _newVersion) { 
		  _db.execSQL("DROP TABLE IF EXISTS " + Consume_types); 
		  onCreate(_db);
	 	}
		  
	}
	
	public Findata(Context _context){
		context = _context;
	}

		
	//���� SQLiteOpenHelper ��getWritableDatabase()��getReadableDatabase() ������
	
		public void open() throws SQLiteException{
			
			dbOpenHelper = new DBOpenHelper (context, DB_Name,null,DB_Version);
			
			try {
				findb = dbOpenHelper.getWritableDatabase();
				
			}catch(SQLiteException ex){
				findb = dbOpenHelper.getReadableDatabase();
			}	
		}
	

	public void close(){
		if(findb != null)
		//�ر����ݿ�
			findb.close();
			findb = null;
			
	}
	
}
