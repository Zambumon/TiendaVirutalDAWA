# Guia de MongoDB

**Vocabulario**

- DB: conjunto de colecciones
- Collection: conjunto de documentos
- Document: normalmente es un JSON
- field: campo de un documento.

### Setup

##### Unix
1. Descargar el paquete de los repos:```apt-get install mongodb```
2. Arrancamos el servicio: ```service mongodb start```
3. Escribimos ```mongo``` para acceder a la consola
4. Crear un BD: ```use nuevaBD```

##### Intellij
1. Settings > plugins > buscar "mongodb" > buscar en repos > instalar
2. Buscamos el plugins (doble shift) > Le indicamos el comando para abrir mongo en el shell ```mongo``` y añadimos una nueva conexión clicando ```+``` e indicando cualquier label.

### Acciones básicas
4. Crear una nueva coleccion: ```db.createCollection("nuevaColeccion","opciones")```, todos los campos son opcionales, autoIndexId te permite que la BD lleve ella sola el indexado de documentos ```{ capped : boolean, autoIndexId : boolean, size :number, max : number}```

5. Insertar documentos: ```db.nuevaCollecion.insert(document)```

6. Borrar una collection: ```db.nuevaColeccion.drop()```

5. ```bd.nombreCollecion.find(criterios)```: devuelve los Json que cumplen con los criterios

Ejemplo de criterios:

**SQL**
```sql
where likes>10 AND (by = 'tutorials point' OR title = 'MongoDB Overview')
```

**Mongo**: los comparadores son ```($lt,$lte,$gt,$gte y $ne)``` el or es ```$or```. Los and y equals son por defecto
```json
{
	"likes": {$gt:10},
	$or: [
		{"by": "tutorials point"},
   		{"title": "MongoDB Overview"}
	]
})
```
6. Updates:

 - ```db.nombreColeccion.update(criterio_seleccion, campos_actualizados)``` Buscas igual que lo haces con find y en campos actualizados pones el Json solo los campos que quieres actualizar.

 - ```db.nombreColeccion.save(nuevoElemento)``` que sobrescribe completamente el elemento con el mismo id.

8. Removes: ```db.COLLECTION_NAME.remove(DELLETION_CRITTERIA)```
9. Indexando: *Por defecto mongoDB no indexa* para indexar necesitas indicarle que campo quieres utilizar para indexar: ```db.nombreColleccion.ensureIndex({"title":1,"description":-1})``` indexa por título en orden ascendente y por descrición en orden descendente. Podemos utilizar esto para crear claves únicas(consultar).
