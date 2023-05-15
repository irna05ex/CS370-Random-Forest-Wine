import org.junit.Test;
public class TestRandomForest
{

  @Test
  public void test1()
  {
  //system wise unit testing
    //Expected outcome test
    RandomForest r = new RandomForest(13, 13, null);
    //test a wine that is of good quality
    Wine w = new Wine();
    w.setType("red");
    w.setFixedAcidity(11);
    w.setVolatileAcidity(0.3);
    w.setCitricAcid(0.58);
    w.setResdidualSugar(2.1);
    w.setChlorides(0.054);
    w.setFreeSulfur(7);
    w.setTotalSulfur(19);
    w.setDensity(0.998);
    w.setpH(3.31);
    w.setSulphates(0.88);
    w.setAlcohol(10.5);
    int g = 0;
    for(it a = 0; a < 9; a++)
    {
      if (t.Test(w) == "good quality") g++;
    }
    int b = 0;
    if(g >= 8) b = 1;
    assertEquals(b, 1);
  }
  @Test
  public void test2()
  {
     //test a rf that has invalid input
     bool b = false;
     try
     {
      RandomForest r = new RandomForest("boo", 13, null);
     }
     catch(NumberFormatException e)
     {
      b = true;
     }
     assertTrue(b);
  }
  
}
