# CharacterIdentifier

Imagine you see a peculiar character such as the wrapped present icon — 🎁 or a letter that might be 0 (zero) or O(capital O), you can’t tell with that font. You copy and paste the character into this new app. It then:

Displays it for you in a large font e.g. é
Tells you its hex and decimal Unicode numbers. e.g. hex: 0x00e9 decimal: 233.
Shows you the alpha, hex and decimal entities e.g. alpha entity: &eacute;, hex entity: &#x00e9; decimal entity &#233; to generate the character.
Shows you how to code it in Java e.g. \u00e9.
Shows you what the character will look like in hex when encoded in UTF-8 e.g. e9.
Tells you in words what the character is, e.g. Latin small letter e with acute.
Then you know what the character is, what it is for and how to use it in your HTML (Links to an external site.) (Hypertext MarkupLanguage) and Java programs.

You can utilize the project Entities (Links to an external site.) to help you with processing the input. The Entities package contains a table called entityfacts.csv which gives you most of the printable characters, their codes, entities and descriptions. You can get the remainder from the Unicode consortium (Links to an external site.). Your Applet would contain a serialized, gzipped, pruned version of that merged table as a resource. You can generate the hex and decimal entities on the fly. They do not have to be embedded in the resource. 
