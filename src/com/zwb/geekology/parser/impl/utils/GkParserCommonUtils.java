package com.zwb.geekology.parser.impl.utils;

public class GkParserCommonUtils
{
	public static boolean compareReformatRemoveStartingThe(String string0, String string1)
	{
		String s0 = removeStartingThe(reformat(string0));
		String s1 = removeStartingThe(reformat(string1));
		return s0.equals(s1);
	}
	
	public static boolean compareReformat(String string0, String string1)
	{
		String s0 = reformat(string0);
		String s1 = reformat(string1);
		return s0.equals(s1);
	}
	
	private static String removeStartingThe(String string)
	{
		if(string.startsWith("the "))
		{
			string = string.substring(4);
		}
		return string;
	}
	
	private static String reformat(String string)
	{
		String s = string.trim();
		s = s.toLowerCase();
		s = replaceUmlauts(s);
		s = removeAccents(s);
		return s;
	}
	
	private static String replaceUmlauts(String s)
	{
		s = s.replaceAll("�", "ae");
		s = s.replaceAll("�", "ue");
		s = s.replaceAll("�", "oe");
		s = s.replaceAll("�", "ss");
		return s;
	}

	
	private static String removeAccents(String s)
	{
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "a");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "e");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "o");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "u");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "i");
		s = s.replaceAll("�", "oe");
		return s;
	}
}
