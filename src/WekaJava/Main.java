package WekaJava;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Đọc dữ liệu
		Preprocess_Data data = new Preprocess_Data();
//		data.loadData("C:\\Program Files\\Weka-3-8-6\\data\\weather.numeric.arff");
		data.loadData("D:\\Content_Crawl_Data2.csv");
		System.out.println(data.outData());
		
		//Xuất dữ liệu dạng file ARFF
//		data.saveData_ARFF("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\weather_NuToNo.arff");
		//Xuất dữ liệu dạng file csv
//		data.saveData_ARFF_CSV("D:\\Infinity\\ChuanbiHK6\\Khai thác dữ liệu và ứng dụng\\Chính\\Databases\\weather_NuToNo.csv");
		
		//Thuật toán Apriori
//		Apriori_AR data = new Apriori_AR();
//		data.loadData("C:\\Program Files\\Weka-3-8-6\\data\\weather.numeric.arff");
//		data.convertNu2No("-R first-last");
//		data.Mine_AR_Apriori("-N 15 -T 0 -C 0.5 -D 0.05 -U 1.0 -M 0.1 -S -1.0 -c -1");
//		System.out.println(data.output_AR_Apriori());
		
		//Thuật toán FPGrowth
//		FPGrowth_AR data = new FPGrowth_AR();
//		data.loadData("C:\\Program Files\\Weka-3-8-6\\data\\weather.numeric.arff");
//		data.convertNu2No("-R first-last");
//		data.convertNo2Bi("-N -R first-last");
//		data.convertNu2Bi("-R first-last");
//		data.mine_AR_FPG("-P 2 -I -1 -N 10 -T 0 -C 0.9 -D 0.05 -U 1.0 -M 0.1");
//		System.out.println(data.Output_AR_FPG());
		
		
	}

}















