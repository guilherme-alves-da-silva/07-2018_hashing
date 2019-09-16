package hash.foo1;

import java.io.IOException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class Hash{
	private String path;
	private int amountOfBuckets;

	public Hash(String path, int amountOfBuckets) throws IOException{
		this.path=path+"bucket_";
		this.amountOfBuckets=amountOfBuckets;

		createFiles();
	}
	private void createFiles() throws IOException{
		for(int i=0;i<amountOfBuckets;i++){
			File file=new File(path+i);

			if(!file.exists()) file.createNewFile();
		}
	}
	private boolean findIndex(int index) throws IOException{
		File file=new File(path+index % amountOfBuckets);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		boolean found=false;

		while(br.ready()&&!found)
			if(br.readLine().split("-")[0].equals(Integer.toString(index))) found=true;

		br.close();
		fr.close();

		return found;
	}
	public void insert(int index, String value) throws IOException{
		if(!findIndex(index)){
			File file=new File(path+index % amountOfBuckets);
			FileWriter fw=new FileWriter(file, true);
			BufferedWriter bw=new BufferedWriter(fw);

			bw.write(index+"-"+value+"\n");

			bw.close();
			fw.close();
		}
		else System.out.println("ERROR! "+index+" is already in use, please use a different index.");
	}
	public void getValue(int index) throws IOException{
		File file=new File(path+index % amountOfBuckets);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);

		while(br.ready()){
			String line=br.readLine();
			if(line.substring(0, line.indexOf("-")).equals(Integer.toString(index))){
				System.out.println("the content stored at the index "+index+" is:\n"+line.substring(line.indexOf("-")+1, line.length()));
				break;
			}
		}
		br.close();
		fr.close();
	}
}
