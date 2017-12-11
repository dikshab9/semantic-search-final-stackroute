# semantic-search-final-stackroute
Semantic search is a search engine which is build on top of Google API and provides results which are semantically accurate. Semantic accuracy means that on searching for a query the results which are more relevant must appear before lesser relevant results.

The indexing pipeline consists of the google API, crawler, parser and indexer. the result from indexer goes to a neo4j concept graph .

Google API: takesthe domain and concept from domain expert and searches for the same in Google. Brings back around 40 results(links) 
Crawler:Takes each link and converts it to xml format before sending it to parser
Parser: calculates the term score. i.e: number of times the term occurs in a document. Eg: one of the base node in neo4j intent graph is
basic which consists of sub terms like fundamental,main etc . parser gives scores to all these terms based on their number of occurences in 
the document.
Neo4j intent garph: consists of 6 main nodes based on the intent csv file which are basic, examples, troubleshooting,getting started,
complete reference,tutorials. These nodes consists of various sub terms which are connected to these nodes by the relation"subconceptOf".
Indexer: Calculates the confidant score of each document ,i.e how much percent basic or tutorial or example the document is. For a basic
query the document which has the highest basic score will apppear on top 
After the scores are obtained the indexer populates the neo4jconcept graph with the links according to their confidant scores.

workflow-> the domain expert populates a domain with concepts. Eg: java domain, concepts- interface,exception,abstraction etc.
This is then followed by the indexing pipeline explained above.


This product also consists of an NLP pipeline.
Spellchecker-> checks for spelling mistake sin the quer and corrects it
POS-> Parts of speech service which identifies whether a word is a noun , verb , adverb etc.
NER-> Identifies the concept from the query eg: tell me something about intefrace (interface-> concept)
Stopwords-> removes words like is,a ,to,the which are unnecessary to undesratnd the user's intent for making the query
Intent seach Service-> finds out the intent from the query and searches for the parent node of the intent in the neo4j intent graph.
understands whether the intent of the user(basic, tutorial, example etc).
