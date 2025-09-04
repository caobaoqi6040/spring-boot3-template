package dev.caobaoqi6040.backend.utils;

import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

/**
 * DataFakerUtils
 *
 * @author caobaoqi6040
 * @since 2025/9/4 11:15
 */
public class DataFakerUtils {

	private static Faker chinaInstance;
	private static Faker chinaInstanceWithSeed;

	private DataFakerUtils() throws IllegalAccessException {
		throw new IllegalAccessException("what are you doing !?");
	}

	public static Faker getChinaInstance() {
		if (chinaInstance == null) {
			chinaInstance = new Faker(Locale.CHINA);
		}
		return chinaInstance;
	}

	public static Faker getChinaInstanceWithSeed() {
		if (chinaInstanceWithSeed == null) {
			chinaInstanceWithSeed = new Faker(Locale.CHINA, new Random(1L));
		}
		return chinaInstanceWithSeed;
	}

}
