package com.hugotrindade.carrinho.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static List<Integer> decodeIntList(String numeros){
		
		return Arrays.stream(numeros.split(","))
				.map(text -> Integer.parseInt(text))
				.collect(Collectors.toList());
	}
}
