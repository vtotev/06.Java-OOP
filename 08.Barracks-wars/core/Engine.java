package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.*;
import barracksWars.interfaces.Runnable;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private static final String COMMANDS_PACKAGE_NAME = "barracksWars.core.commands.";

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) {
		Executable command = null;
		String result;

		try {
			commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1).toLowerCase();
			Class<?> clazz = Class.forName(COMMANDS_PACKAGE_NAME + commandName);
			Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
			command = (Executable) ctor.newInstance(data, repository, unitFactory);

			//cmd

		} catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return command.execute();
//		switch (commandName) {
//			case "add":
//				result = this.addUnitCommand(data);
//				break;
//			case "report":
//				result = this.reportCommand(data);
//				break;
//			case "fight":
//				result = this.fightCommand(data);
//				break;
//			default:
//				throw new RuntimeException("Invalid command!");
//		}
	}


}
