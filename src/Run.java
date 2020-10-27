import java.util.*;

public class Run {
	public static void main(String[] args) {

		//Halmazok
		Set<Student> shs = new HashSet<>();
		shs.add(new Student("Anna","ABC123",21));
		shs.add(new Student("Béla","DEF456",23));
		shs.add(new Student("Dénes","GHI789",22));
		shs.add(new Student("Elemér","JKL123",22));
		shs.add(new Student("Cecil","MNO456",21));
		shs.add(new Student("Anna","HZJ453",22));
		shs.add(new Student("Anna","ABC123",21));
		System.out.println(shs);

		Set<Student> sts = new TreeSet<>();
		sts.add(new Student("Anna","ABC123",21));
		sts.add(new Student("Béla","DEF456",23));
		sts.add(new Student("Dénes","GHI789",22));
		sts.add(new Student("Elemér","JKL123",22));
		sts.add(new Student("Cecil","MNO456",21));
		sts.add(new Student("Anna","HZJ453",22));
		sts.add(new Student("Anna","ABC123",21));
		System.out.println(sts);

		Set<Student> sts2 = new TreeSet<>(new Comparator<Student>() {        // TreeSet esetén a rendezés módja paraméterben is átadható, például egy névtelen osztály használatával
			@Override
			public int compare(Student o1, Student o2) {
				return o1.name.compareTo(o2.name);
			}
		});
		sts2.add(new Student("Anna","ABC123",31));
		sts2.add(new Student("Anna","HZJ453",22));
		System.out.println(sts2);

		Set<Student> sts3 = new TreeSet<>(new Student.SortByCodeAndAge());
		sts3.add(new Student("Anna","ABC123",31));
		sts3.add(new Student("Anna","HZJ453",22));
		System.out.println(sts3);

		sts3.clear();
		if(sts3.isEmpty()){
			System.out.println("Üres halmaz.");
		}
		sts3.add(new Student("Béla", "CBA321", 26));
		sts3.add(new Student("Emma", "CBA123", 22));
		if(sts3.contains(new Student("Béla", "CBA321", 26))){
			System.out.println("Béla tanuló.");
		}else{
			System.out.println("Béla nem tanuló.");
		}
		sts3.remove(new Student("Béla", "CBA321", 26));
		if(sts3.contains(new Student("Béla", "CBA321", 26))){
			System.out.println("Béla még tanuló.");
		}else{
			System.out.println("Béla már nem tanuló.");
		}
		System.out.println("Tömbként: " + Arrays.toString(sts3.toArray()));

		System.out.println(" - - - - - ");

		//Listák
		List<Student> sal = new ArrayList<>();

		if(sal.isEmpty()){
			System.out.println("Üres lista.");
		}

		sal.add(new Student("Anna","ABC123",21));
		sal.add(new Student("Béla","DEF456",23));
		sal.add(new Student("Cecil","MNO456",21));
		sal.add(new Student("Anna","HZJ453",22));
		sal.add(new Student("Anna","ABC123",21));
		System.out.println(sal);

		int duplicateIndex = sal.lastIndexOf(new Student("Anna","ABC123",21));
		sal.set(duplicateIndex, new Student("Gábor", "CBA321", 26));
		System.out.println("Átrendezve: " + sal);
		//Comparable elemek rendezése
		Collections.sort(sal);
		System.out.println("Rendezve: " + sal);
		//Rendezés Comparatorral
		sal.sort(new Student.SortByCodeAndAge());
		System.out.println("Comparatorral rendezve: " + sal);
		//Részlet
		List<Student> subSal = sal.subList(0,2);
		System.out.println("Részlet: " + subSal);

		List<Student> sll = new LinkedList<>();
		sll.add(new Student("Anna","ABC123",21));
		sll.add(new Student("Béla","DEF456",23));
		sll.add(new Student("Cecil","MNO456",21));
		sll.add(new Student("Anna","HZJ453",22));
		sll.add(new Student("Anna","ABC123",21));
		System.out.println(sll);

		System.out.println(" - - - - - ");

		//Táblázatok
		Map<String, String> translate = new HashMap<>();
		translate.put("alma", "apple");
		translate.put("nagy", "big");
		translate.put("finom", "delicious");
		System.out.println("Van nagy? " + translate.putIfAbsent("nagy", "great"));
		translate.remove("nagy");
		System.out.println("Van nagy? " + translate.putIfAbsent("nagy", "great"));
		translate.replace("nagy", "big");
		System.out.println("nagy-" + translate.get("nagy"));
		translate.replace("nagy", "great", "huge");
		System.out.println("nagy-" + translate.get("nagy"));
		System.out.println("Kulcsok száma: " + translate.size());

		if(translate.containsKey("alma")){
			System.out.println("Van alma.");
		}
		if(translate.containsValue("apple")){
			System.out.println("Apple is present.");
		}
		String blue = translate.getOrDefault("kék", "Not Found");
		System.out.println("Kék: " + blue);

		//Kiíratás
		System.out.println(" - - A szótár: - - ");
		for(Map.Entry<String, String> item: translate.entrySet()){
			System.out.println(item.getKey() + ": " + item.getValue());
		}
		System.out.println(" - - - - - ");

		//Van Hash és Tree Map. Ugyanaz a logika, mint a Set esetében.
		Map<String, List<Student>> mssl = new TreeMap<>();
		mssl.put("Debrecen", new ArrayList<>());

		//Beilleztés akkor is, ha még nem létezik az elem.
		String name = "Debrecen";
		List<Student> value = mssl.get(name);
		if(value == null){
			value = new ArrayList<>();
			mssl.put(name, value);
		}
		value.add(new Student("Anna","ABC123",21));
		value.add(new Student("Béla","DEF456",23));

		name = "Szeged";
		value = mssl.get(name);
		if(value == null){
			value = new ArrayList<>();
			mssl.put(name, value);
		}
		value.add(new Student("Dénes","GHI789",22));
		value.add(new Student("Elemér","JKL123",22));

		//Foreach bejérás. Map.Entry típusú értékeket kapunk
		for(Map.Entry<String, List<Student>> item: mssl.entrySet()){
			System.out.println(item.getKey() + ": " + item.getValue());
		}
	}
}
