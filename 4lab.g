grammar ValentFourLab;
options 
{language = CSharp3;}

public
main: declaration* statement*;
statement : assign | selectcase;

selectcase: Select selectdeclaration casebody End statement*;
selectdeclaration: Ident | const | arifmoperation;
casebody: Case LbParam operands RbParam statement+ casebody?;

declaration: 
	typedata Ident (IdentSep Ident)* LineSep 
	| Typenumber Ident Prisv Constnumber LineSep
	| Typereal   Ident Prisv Constreal LineSep  
	| Typechar   Ident Prisv Constchar LineSep  
	| Typebool   Ident Prisv Constbool LineSep;
	
assign: Ident Prisv operands LineSep statement*;
arifmoperation: (Ident | const) ArifmOp operands
	| Ident ArifmOpExt
	| LbParam arifmoperation RbParam;
typedata: Typenumber | Typereal | Typechar | Typebool;
const: Constnumber | Constreal | Constchar | Constbool | Constseven;

operands: Ident | const | arifmoperation;


WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

Typenumber : 'number';
Typereal : 'real';
Typechar : 'char' | 'chara' | 'charac' | 'charact' | 'characte' | 'character';
Typebool : 'bool';

Constnumber : '0'..'9'+;
Constreal: ('0'..'9')+ '.' ('0'..'9')* Exp?|'.' ('0'..'9')+ Exp?|('0'..'9')+ Exp;
Constchar: '\'' ('a'..'z'|'A'..'Z' | '0'..'9') '\'';
Constbool: 'L_T' | 'L_F';
Constseven: 'S' ('1'..'6')('0'..'6')*;
Exp: ('e'|'E') ('+'|'-')? ('0'..'9')+;	

ArifmOp: '+' | '-' | '*' | '/' ;
ArifmOpExt: '++' | '--';
LogOp: 'and' | 'or' | '=' | '>' | '<' | '!=' | '<=' | '>=';
LbParam: '(';
RbParam: ')';
LfBracket: '{';
RfBracket: '}';
LineSep: ';';
Prisv: ':=';
IdentSep: ',';

Select: 'select';
Case: 'case';
End: 'end';
Ident: ('a'..'z'|'A'..'Z')('0'..'9')((('a'..'z'|'A'..'Z')*)|(('0'..'9')*));