grammar ThreeLab;
options 
{language = CSharp3;}

@header
{ using translatorCoursework;}

@members
{
	
}

public

 WS  :   ( ' '
    | '\t'
    | '\r'
    | '\n'
    | Ignored
    ) {$channel=HIDDEN;}
; 

ab	: (A|B)*;

Ignored	:	('(')|(')')|'*'|'+';
A	:	'A'|'a';
B	:	'B'|'b';


