/*Ravi Patel
 * Assignment 3 Exercise 3
 * CS 3401 Data Structures
 */

package cs3401assignment3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

public class A3_Exercise3_3 
{
	public static void main(String[] args)
	{
		String[][] statecapital = {
			      {"Alabama", "Montgomery"},
			      {"Alaska", "Juneau"},
			      {"Arizona", "Phoenix"},
			      {"Arkansas", "Little Rock"},
			      {"California", "Sacramento"},
			      {"Colorado", "Denver"},
			      {"Connecticut", "Hartford"},
			      {"Delaware", "Dover"},
			      {"Florida", "Tallahassee"},
			      {"Georgia", "Atlanta"},
			      {"Hawaii", "Honolulu"},
			      {"Idaho", "Boise"},
			      {"Illinois", "Springfield"},
			      {"Maryland", "Annapolis"},
			      {"Minnesota", "Saint Paul"},
			      {"Iowa", "Des Moines"},
			      {"Maine", "Augusta"},
			      {"Kentucky", "Frankfort"},
			      {"Indiana", "Indianapolis"},
			      {"Kansas", "Topeka"},
			      {"Louisiana", "Baton Rouge"},
			      {"Oregon", "Salem"},
			      {"Oklahoma", "Oklahoma City"},
			      {"Ohio", "Columbus"},
			      {"North Dakota", "Bismark"},
			      {"New York", "Albany"},
			      {"New Mexico", "Santa Fe"},
			      {"New Jersey", "Trenton"},
			      {"New Hampshire", "Concord"},
			      {"Nevada", "Carson City"},
			      {"Nebraska", "Lincoln"},
			      {"Montana", "Helena"},
			      {"Missouri", "Jefferson City"},
			      {"Mississippi", "Jackson"},
			      {"Massachusettes", "Boston"},
			      {"Michigan", "Lansing"},
			      {"Pennslyvania", "Harrisburg"},
			      {"Rhode Island", "Providence"},
			      {"South Carolina", "Columbia"},
			      {"South Dakota", "Pierre"},
			      {"Tennessee", "Nashville"},
			      {"Texas", "Austin"},
			      {"Utah", "Salt Lake City"},
			      {"Vermont", "Montpelier"},
			      {"Virginia", "Richmond"},
			      {"Washington", "Olympia"},
			      {"West Virginia", "Charleston"},
			      {"Wisconsin", "Madison"},
			      {"Wyoming", "Cheyenne"}
			    };
		
		List<String[]> list2 = Arrays.asList(statecapital);
		Collections.shuffle(list2);
		
		int correctanswer = 0;
		int incorrectanswer = 0;
		
		for (int i = 0; i < statecapital.length; i++)
		{
			for (int j = 0; j < statecapital[i].length; j++)
			{
				
			}
				
				String userinput = JOptionPane.showInputDialog("What is the capital of " + statecapital[i][0] + "?");
				String capital = (String) userinput;
				
				if (capital == null)
				{
					incorrectanswer++;
					System.exit(0);
				}
				else
				{
					if (capital.equals(statecapital[i][1]))
					{
						JOptionPane.showMessageDialog(null, "Correct Answer");
						
						correctanswer++;
						
					}
					else
					{
						incorrectanswer++;
						JOptionPane.showMessageDialog(null, "That is the incorrect answer.  Total number correct: " + correctanswer + "!" + " Total number of incorrect answer: " + incorrectanswer + "!");

					}
				}
		}
	}

}
