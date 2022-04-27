
import java.util.Scanner;

public class SocSecProcessor

{

	public static void main(String[] args)

	{

		Scanner keyboard = new Scanner(System.in);

		String name;

		String socSecNumber;

		String response;

		char answer = 'Y';

		while (Character.toUpperCase(answer) == 'Y')

		{

			try

			{

				// Task #2 step 1 - To do:

				// promote user to enter name and ssn number.

				// save the input to variable name and SocSecNumber. Such as:

				// System.out.print("Name? ");

				// name = keyboard.nextLine();

				// validate SSN number by calling isValid(socSecNumber).

				// output the checking result.

				System.out.print("Name?");

				name = keyboard.nextLine();

				System.out.print("SSN?");

				socSecNumber = keyboard.nextLine();

				if (isValid(socSecNumber)) {

					System.out.println(name + " " + socSecNumber + " is valid");

				}

			}
			// To do: catch the SocSecException

			catch (SocSecException e)

			{

				System.out.println(e.getMessage());

			}

			System.out.print("Continue?");

			response = keyboard.nextLine();

			answer = response.charAt(0);

		}

	}

	private static boolean isValid(String number) throws SocSecException

	{

		boolean goodSoFar = true;

		int index = 0;

		// To do: Task #2 step 2

		// 1. check the SSN length. Throw SocSecException if it is not 11

		if (number.length() != 11)

		{

			throw new SocSecException("wrong number of characters ");

		}

		for (index = 0; index < number.length(); ++index) {

			if (index == 3 || index == 6) {

				if (number.charAt(index) != '-') {

					throw new SocSecException("dashes at wrong positions");

				}

			} else if (!Character.isDigit(number.charAt(index))) {

				throw new SocSecException("contains a character that is not a digit");

			}

		}

		// 2. check the two "-" are in right position. Throw SocSecException if it is
		// not

		// if (number.charAt(3) != '-')

		// 3. check other position that should be digits. Throw SocSecException if it is
		// not

		// if (!Character.isDigit(number.charAt(index)))

		return goodSoFar;

	}
}
