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
		s = s.replaceAll("ä", "ae");
		s = s.replaceAll("ü", "ue");
		s = s.replaceAll("ö", "oe");
		s = s.replaceAll("ß", "ss");
		return s;
	}

	
	private static String removeAccents(String s)
	{
		s = s.replaceAll("á", "a");
		s = s.replaceAll("à", "a");
		s = s.replaceAll("â", "a");
		s = s.replaceAll("é", "e");
		s = s.replaceAll("è", "e");
		s = s.replaceAll("ê", "e");
		s = s.replaceAll("ó", "o");
		s = s.replaceAll("ò", "o");
		s = s.replaceAll("ô", "o");
		s = s.replaceAll("ú", "u");
		s = s.replaceAll("ù", "u");
		s = s.replaceAll("û", "u");
		s = s.replaceAll("í", "i");
		s = s.replaceAll("ì", "i");
		s = s.replaceAll("î", "i");
		s = s.replaceAll("ø", "oe");
		return s;
	}
}
