import org.junit.Test;
public class TestGUI
{
  @Test
  public void test1()
  { //wring varaiable type for input test
      bool catch = false;
      try
      {
          Wine w = new Wine();
          w.setType("red");
          w.setFixedAcidity("cheese");
          w.setVolatileAcidity(0.3);
          w.setCitricAcid(0.58);
          w.setResdidualSugar(2.1);
          w.setChlorides(0.054);
          w.setFreeSulfur("Dimetrodon");
          w.setTotalSulfur(19);
          w.setDensity(0.998);
          w.setpH(3.31);
          w.setSulphates(0.88);
          w.setAlcohol(10.5);
      }
      catch(NumberFormatException e)
      {
          catch = true;
      }
      assertTrue(catch);
    }
}
