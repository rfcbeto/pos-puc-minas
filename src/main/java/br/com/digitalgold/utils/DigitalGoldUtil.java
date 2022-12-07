package br.com.digitalgold.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DigitalGoldUtil {

	  public static String truncarEmDuasCasasDecimais(Double valor) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return new DecimalFormat("#,##0.00").format(valor);
	  }

}
