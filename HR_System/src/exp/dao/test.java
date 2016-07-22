package exp.dao;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.err.println(new EmpOutDao().fubyouttime("2016-07-01", "2016-07-31"));
		//System.err.println(new Utils().SptString("")[1]);
        System.err.println(new EmpInDao().fubyintime("2016-07-01", "2016-07-31"));
	}
}
