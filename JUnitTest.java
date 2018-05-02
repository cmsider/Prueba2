package tomos;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

	private MapeadoDeTomos mdt;
	
	@Before
	public void antes() {
		mdt = new MapeadoDeTomos();
	}
	
	@Test
	public void test1() {
		mdt.n = 103;
		mdt.dominio = new String[]  {"aa", "ba", "ca", "da", "ea", "fa", "ga", "ha", "ia", "ja", "ka", "la", "ma", 
			"na", "oa", "pa", "qa", "ra", "sa", "ta", "ua", "va", "wa", "xa", "ya", 
			"Aa", "Ba", "Ca", "Da", "Ea", "Fa", "Ga", "Ha", "Ia", "Ja", "Ka", "La", "Ma", 
			"Na", "Oa", "Pa", "Qa", "Ra", "Sa", "Ta", "Ua", "Va", "Wa", "Xa", "Ya",
			"ab", "bb", "cb", "db", "eb", "fb", "gb", "hb", "ib", "jb", "kb", "lb", "mb", 
			"nb", "ob", "pb", "qb", "rb", "sb", "tb", "ub", "vb", "wb", "xb", "yb", 
			"Ab", "Bb", "Cb", "Db", "Eb", "Fb", "Gb", "Hb", "Ib", "Jb", "Kb", "Lb", "Mb", 
			"Nb", "Ob", "Pb", "Qb", "Rb", "Sb", "Tb", "Ub", "Vb", "Wb", "Xb", "Yb"};
	}

	@Test
	public void test2() {
		mdt.n = 65;
		mdt.dominio = new String [] {"A", "B", "C", "D", "E", "F"};	
	}
	
	@Test
	public void test3() {
		mdt.n = 100;
		mdt.dominio = new String [] {"@", "#", "$", "%", "^", "&", "*"};	
	}
	
	@Test
	public void test4() {
		mdt.n = 132;
		mdt.dominio = new String [] {"MONOS", "LEONES", "CEBRAS", "GATOS"};	
	}
	
	@After
	public void despues() {
		mdt.a = mdt.n / mdt.u; // parte alta
		mdt.b = mdt.n % mdt.u; // parte baja
		mdt.c = (mdt.a + mdt.b) / mdt.u; // carry
		mdt.e = (mdt.a + mdt.b) % mdt.u + mdt.c; // acomodo
		mdt.l = mdt.dominio.length; // tamaño del dominio
		mdt.k = mdt.dominio[mdt.a + mdt.c].length(); // tamaño del nombre 
		mdt.s = mdt.dominio[mdt.a + mdt.c]; // nombre
		
		String res = mdt.numeracionDeTomos(mdt.n,mdt.dominio);
		System.out.println(res);
		Assert.assertTrue(res.matches("^.{1,20}-(0[1-9]|[1-9][0-9])$"));
	}

}