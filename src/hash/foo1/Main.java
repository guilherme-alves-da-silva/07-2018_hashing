package hash.foo1;

import java.io.IOException;

public class Main{
	//args[0]: pathToStoreTheBuckets, args[1]: amountOfBuckets
	//example: java hash.foo1.Main "/path/to/store/the/buckets/" 4 
	public static void main(String[] args) throws IOException{
		Hash a=new Hash(args[0], Integer.parseInt(args[1]));

		a.insert(2, "asd");
		a.getValue(2);

		a.insert(15, "qwe");
		a.getValue(15);
	}
}
//aluno guilherme alves
