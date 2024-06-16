package stack;

public class Output {
	void fun(int n){
	    if (n==0)
	    return ;
	    fun(n-1);
	    print("%d",n);
	}

	private void print(String string, int n) {
		// TODO Auto-generated method stub
		
	}

	int main(){
	    fun(5);
	    return 0;
	}
}
