import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class TodoApp {

	static List<Todo> list = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		File file = new File("todo.csv");
		System.out.println("***TodoApp***");

		if(file.exists()) {
			readFile(file);
		}
		
		//新しいファイルが作られた時に動く部分
		while(true) {
			showTodo();
			System.out.println("---操作を入力して下さい---");
			System.out.println("1/登録 2/重要度変更 3/削除 4/終了");

			int select = scan.nextInt();
			scan.nextLine();
			
			//受け取った入力に対して処理を変える部分
			switch(select){
			case 1:
				createTodo();
				break;
			case 2:
				alterTodo();
				break;
			case 3:
				deleteTodo();
				break;
			default:
				System.out.println("アプリケーションを終了します");
				saveFile(file);
				scan.close();
				return;
			}
		}
	}

	//ファイルを保存すメソッド
	private static void saveFile(File file) {
		BufferedWriter bw = null;
		
		//エラー処理
		try {
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
			bw = new BufferedWriter(osw);

			for(Todo todo:list) {
				bw.append(todo.toCSV());
				bw.newLine();
			}
			bw.flush();
		}
		catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(bw != null) {
				try {
					bw.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//ファイルの読み込みをするメソッド
	private static void readFile(File file) {

		BufferedReader br = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
			br = new BufferedReader(isr);
			String line;

			while((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Todo todo = new Todo(data[0],Integer.parseInt(data[1]));
				list.add(todo);
			}
		}

		catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}

		finally {
			if(br != null) {
				try {
					br.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//ファイルの中を見るメソッド
	private static void showTodo() {

		if(list.size() == 0) {
			System.out.println("Todoは1件もありません");
			return;
		}

		//for文を回してTodoクラス
		for(int i = 0 ; i < list.size(); i++) {
			for(int j = i+1; j < list.size(); j++) {
				if(list.get(i).getImportance()<list.get(j).getImportance()) {
					Todo temp = list.get(i);
					list.set(i, list.get(j));
					list.set(j,temp);
				}
			}
		}
		
		//
		for(int i = 0; i < list.size();i++) {
			System.out.println(i+"・・・"+list.get(i).toString());
		}
	}

	//新しいTodoを作るメソッド
	private static void createTodo() {
		
		System.out.println("新規Todoを作成します");
		System.out.println("Todoの内容を入力してください");
		String todo = scan.nextLine();

		System.out.println("重要度を１～１０で入力してください");
		int importance = scan.nextInt();

		Todo t = new Todo(todo,importance);
		list.add(t);
		System.out.println("1件追加しました");
	}

	//重要度を変更するメソッド
	private static void alterTodo() {
		if(list.size() == 0) {
			System.out.println("まだTodoはありません");
			return;
		}
		System.out.printf("重要度を変更します。番号を入力してください。%d~%d>",0,list.size()-1);
		int index = scan.nextInt();

		System.out.println("重要度を再設定してください");
		int importance = scan.nextInt();
		list.get(index).setImportance(importance);
		System.out.println("重要度を変更しました");
	}

	//Todoを削除するメソッド
	private static void deleteTodo() {
		//Todoに何もない時の処理
		if(list.size() == 0) {
			System.out.println("まだTodoはありません");
			return;
		}
		
		//Todoを処理する部分
		System.out.printf("Todoを削除します。番号を入力してください。%d~%d>", 0,list.size()-1);
		int index = scan.nextInt();
		list.remove(index);
		System.out.println("１件削除しました");
	}

}
