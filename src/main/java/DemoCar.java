
public class DemoCar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		SampleCar dcar = new SampleCar();
		SampleCar ecar = new SampleCar();
		SampleCar fcar = new SampleCar();

		dcar.setMake("BMW");
		System.out.println(dcar.getMake());

		ecar.setMake("Porche");
		fcar.setMake("Toyota");
		fcar = dcar;
		System.out.println(fcar.getMake());
		dcar = ecar;
		System.out.println(dcar.getMake());
		ecar = fcar;

		System.out.println(ecar.getMake());

	}
}