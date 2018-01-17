package com.bnd.test.eval.provider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.osgi.service.component.annotations.Component;

import com.bnd.test.eval.api.Eval;

import osgi.enroute.debug.api.Debug;
import parsii.eval.Parser;
import parsii.tokenizer.ParseException;

/**
 * 
 */
@Component(name = "com.bnd.test.eval",
           property = {
             Debug.COMMAND_SCOPE + "=test",
             Debug.COMMAND_FUNCTION + "=eval"
           }
          )
public class EvalImpl implements Eval {
	/*Pattern EXPR = Pattern.compile( "\\s*(?<left>\\d+)\\s*(?<op>\\+|-)\\s*(?<right>\\d+)\\s*");*/
	
	@Override
	public double eval(String expression) {
		try {
			return Parser.parse(expression).evaluate();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}	
}

