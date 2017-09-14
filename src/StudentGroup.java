
import java.util.Arrays;
import java.util.Date;


/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		return students;
		
	}

	@Override
	public void setStudents(Student[] students) throws IllegalArgumentException  {
		if (students==null)
		{
			throw new IllegalArgumentException();
		}
		
	}

	@Override
	public Student getStudent(int index) throws IllegalArgumentException {
		if(index<0 || index>=students.length)
		{
			throw new IllegalArgumentException();
		}
		return students[index];
		
	}

	@Override
	public void setStudent(Student student, int index) throws IllegalArgumentException {
		if(index<0 || index>=students.length || students==null)
		{
			throw new IllegalArgumentException();
		}
		students[index]=student;
		
	}

	@Override
	public void addFirst(Student student) throws IllegalArgumentException {
		if (students==null)
		{
			throw new IllegalArgumentException();
		}
		
		Student st[]=new Student[students.length+1];
		for(int i=1;i<st.length;i++)
		{
			st[i]=students[i-1];
		}
		st[0]=student;
		int c=1;
		 Arrays.copyOf(students,students.length+c);
		 for(int i=0;i<st.length;i++)
		 {
			 students[i]=st[i];
		 }
		
		
		
		
	}

	@Override
	public void addLast(Student student) throws IllegalArgumentException {
		if (students==null)
		{
			throw new IllegalArgumentException();
		}
		 Arrays.copyOf(students,students.length+1);
		 students[students.length-1]=student;
		
	}

	@Override
	public void add(Student student, int index) throws IllegalArgumentException {
		int i=0;
		
		if(index<0 || index>=students.length || students==null)
		{
			throw new IllegalArgumentException();
		}
		Student st[]=new Student[students.length+1];
		for( i=0;i<index;i++)
		{
			st[i]=students[i];
		}
		st[index]=student;
		for(i=index+1;i<st.length;i++)
		{
			st[i]=students[i-1];
		}
		
		 Arrays.copyOf(students,students.length+1);
		 for( i=0;i<st.length;i++)
		 {
			 students[i]=st[i];
		 }
		
		
	}

	@Override
	public void remove(int index) throws IllegalArgumentException {
		if(index<0 || index>=students.length || students==null)
		{
			throw new IllegalArgumentException();
		}
		Student st[]=new Student[students.length-1];
		students[index]=null;
		for(int i=0;i<students.length;i++)
		{
			if(students[i]!=null)
			{
				st[i]=students[i];
			}
		}
		Arrays.copyOf(students,students.length-1);
		for( int i=0;i<st.length;i++)
		 {
			 students[i]=st[i];
		 }
		
		
	}

	@Override
	public void remove(Student student) throws IllegalArgumentException {
		int i=0;
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		
		
		for(i=0;i<students.length;i++)
		{
			if(students[i].equals(student))
				students[i]=null;
		}
		if(i==students.length)
			throw new IllegalArgumentException();
		
		Student st[]=new Student[students.length-1];
		for(i=0;i<students.length;i++)
		 {
			if(students[i]!=null)
			{
				st[i]=students[i];
			}
		 }
		Arrays.copyOf(students,students.length-1);
		for(i=0;i<st.length;i++)
		 {
			 students[i]=st[i];
		 }
		
		
		
			
		
	}

	@Override
	public void removeFromIndex(int index) {
		int c=0;
		for(int i=index+1;i<students.length;i++)
		{
			students[i]=null;
			c++;
		}
		Student st[]=new Student[students.length-c];
		for(int i=0;i<students.length;i++)
		 {
			if(students[i]!=null)
			{
				st[i]=students[i];
			}
		 }
		Arrays.copyOf(students,students.length-c);
		for ( int i=0;i<st.length;i++)
		 {
			 students[i]=st[i];
		 }
		
	}

	@Override
	public void removeFromElement(Student student) {
		int i=0;
		for( i=students.length-1;i>=0;i--)
		{
			if(students[i].equals(student))
			{
				break;
			}
		}
		Arrays.copyOf(students,students.length-i);
		
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		Student st[]=new Student[students.length-index];
		for(int i=index;i<students.length;i++)
		{
			st[i]=students[i];
		}
		Arrays.copyOf(students,students.length-index);
		for(int i=0;i<students.length;i++)
		{
			students[i]=st[i];
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int y=0;
		for(int i=0;i<students.length;i++)
		{
			if(students.equals(student))
			{
				y=i;break;
			}
		}
		Student st[]=new Student[students.length-y];
		for(int i=y;i<students.length;i++)
		{
			st[i]=students[i];
		}
		Arrays.copyOf(students,students.length-y);
		for(int i=0;i<students.length;i++)
		{
			students[i]=st[i];
		}

	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			for(int j=i+1;j<students.length;j++)
			{
				if(students[i].compareTo(students[j])>0)
				{
					Object o=students[j];
					students[i]=students[j];
					students[j]=(Student)o;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) throws IllegalArgumentException {
		// Add your implementation here
		int c=0;
		if(date==null)
		{
			throw new IllegalArgumentException();
		}
		Student st[]=new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			
			if((students[i].getBirthDate()).before(date))
			{
				st[i]=students[i];
			}
			c++;
		}
		Arrays.copyOf(st,st.length-c);
		
		return st;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) throws IllegalArgumentException {
		int c=0;
		if(firstDate==null || lastDate==null)
		{
			throw new IllegalArgumentException();
		}
		Student st[]=new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			
			if((students[i].getBirthDate()).before(lastDate) && (students[i].getBirthDate()).after(firstDate))
			{
				st[i]=students[i];
			}
			c++;
		}
		Arrays.copyOf(st,st.length-c);
		return st;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max=0;
		// Add your implementation here
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()>max)
				max=students[i].getAvgMark();
		}
		int c=0;
		Student st[]=new Student[students.length];
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getAvgMark()==max)
			{
				st[i]=students[i];
				c++;
			}
		}
		Arrays.copyOf(st,st.length-c);
		return st;
	}

	@Override
	public Student getNextStudent(Student student) throws IllegalArgumentException {
		// Add your implementation here
		if(student==null)
		{
			throw new IllegalArgumentException();
		}
		Student obj=null ;
		for(int i=0;i<students.length;i++)
		{
			
			if(students[i].equals(student))
				 obj=students[i];
		}
		
		return obj;
	}
}
