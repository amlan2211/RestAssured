package authentication;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class FlipKart 
{
	@Test
	public void Test()
	{
		String []s= {"Application","App","Apple"};
		String s1="";
		boolean flag=true;
		for(int i=0;i<s[0].length();i++)
		{
			for(int j=0;j<s.length;j++)
			{
				if(!(s[j].contains(s[0].charAt(i)+"")))
				{
					flag=false;
					break;
				}
			
			}
			if(flag==true)
			{
			    s1+=s[0].charAt(i);
			}
		}
		System.out.println("common letters "+s1);
	}
	@Test
	public void reversetheString()
	{
		String s="this is amlan";
		String rev="";
		for(int i=s.length()-1;i>=0;i--)
		{
			if(s.charAt(i)!=' ')
			{
				rev=rev+s.charAt(i);
			}
		}
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				rev=rev.substring(0, i)+" "+rev.substring(i, rev.length());
			}
		}
		System.out.println(rev);
	}
	@Test
	public void CommonWord()
	{
		String[] s= {"Appilcation","App","Apply"};
		String s1="";
		boolean flag=true;
		for(int i=0;i<s[0].length();i++)
		{
			for(int j=1;j<s.length;j++)
			{
				if(!(s[j].contains(s[0].charAt(i)+"")))
				{
					flag=false;
					break;
				}
				
			}
			if(flag==true)
			{
				s1+=s[0].charAt(i);
			}
		}
		System.out.println(s1);
	}
  @Test
  public void Test1()
  {
	  String s="my name is prakash";
	  String rev="";
	  for(int i=s.length()-1;i>=0;i--)
	  {
		  if(s.charAt(i)!=' ')
		  {
			  rev=rev+s.charAt(i);
		  }
	  }
	  for(int i=0;i<s.length();i++)
	  {
		  if(s.charAt(i)==' ')
		  {
			  rev=rev.substring(0, i)+" "+rev.substring(i, rev.length());
		  }
	  }
	  System.out.println(rev);
  }
  @Test
  public void CountTheSequence()
  {
	  String s="aabbccddee";
	  
	  for(int i=0;i<s.length();i++)
	  {
		  int count=1;
		  for(int j=i+1;j<s.length();j++)
		  {
			  if(s.charAt(i)==s.charAt(j)&& i>j)
			  {
				  break;
			  }
			  else if(s.charAt(i)==s.charAt(j))
			  {
				  count++;
			  }
		  }
		  if(count>1)
		  {
			  System.out.println(s.charAt(i)+""+count);
		  }
	  }
  }
  @Test
  public void CounttheSequence()
  {
	  String s="aabbccddee";
	 for(int i=0;i<s.length();i++)
	 { 
		 int count=1;
		 for(int j=i+1;j<s.length();j++)
		 {
			 if(s.charAt(i)==s.charAt(j)&& i>j)
			 {
				 break;
			 }
			 else if(s.charAt(i)==s.charAt(j))
			 {
				 count++;
			 }
		 }
		 if(count>1)
		 {
			 System.out.println(s.charAt(i)+""+count);
		 }
	 }
  }
  @Test
  public void MergeOfArray()

  {
	  int a[]= {1,2,3,4,5};
	  int b[]= {4,6,8,9,10};
	  int c[]=new int[a.length+b.length];
	  int d=0;
	  for(int i=0;i<a.length;i++)
	  {
		  c[d]=a[i];
		  d++;
	  }
	  for(int i=0;i<b.length;i++)
	  {
		  c[d]=b[i];
		  d++;
	  }
	  for(int i=0;i<c.length;i++)
	  {
		  System.out.println(c[i]);
	  }
  }
  @Test
  public void pattern()
  {
	  int n=3;
	  for(int i=0;i<n;i++)
	  {
		  int m=(i*2)+1;
		  int x=1;
		  for(int j=1;j<=m;j++)
		  {
			  if(j<=i)
			  {
				  System.out.print(x+++" ");
			  }
			  else
			  {
				  System.out.print(x--+" ");
			  }
		  }
		  System.out.println();
	  }
  }
  @Test
  public void T2est()
  {
	  int n=5;
	  for(int i=0;i<n;i++)
	  {
		  for(int j=1;j<=n-i;j++)
		  {
			  System.out.print(" ");
		  }
		  int c=1;
		  for(int j=1;j<=i*2+1;j++)
		  {
			  if(j<=(i*2)/2)
			  {
				  System.out.print((c++)+" ");
			  }
			  else
			  {
				  System.out.print(c--+" ");
			  }
		  }
		  System.out.println();
	  }
		  
  }
  @Test
  public void Map_1()
  {
	  Map<String, Integer> hm=new HashMap<String, Integer>();
	  hm.put("Hello", 12);
	  hm.put("hello2",13);
	  hm.put("h", 123);
	  for(Map.Entry<String, Integer> hs:hm.entrySet())
	  {
		  System.out.println(hs.getKey());
		  System.out.println(hs.getValue());
	  }
  }
  
}
