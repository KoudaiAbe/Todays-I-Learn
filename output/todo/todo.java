public class Todo {
	private String todo;
	private int importance;

	public Todo(String todo,int importance) {
		this.setTodo(todo);
		this.setImportance(importance);
	}

	@Override
	public String toString() {
		return this.todo + "/重要度:" + importance;
	}

	public String toCSV() {
		return this.todo + "," + importance;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		//重要度が10を超えないようにする為の処理
		if(importance > 10) {
			this.importance = 10;
		}else if(importance < 1) {
			this.importance = 1;
		}else {
			this.importance = importance;
		}
	}
}
