MINECRAFT INDEV SETTINGS — proyecto fuente para Minecraft Java 26.3

COMPILACIÓN AUTOMÁTICA CON GITHUB ACTIONS
No necesitás instalar Gradle ni Java en tu PC para compilarlo en GitHub.

1. En GitHub, crea un repositorio nuevo (por ejemplo: MinecraftIndevSettings).
2. Descomprimí este ZIP en tu PC.
3. En la página del repositorio, elegí Add file > Upload files.
4. Arrastrá TODOS los archivos y carpetas de este proyecto, incluida la carpeta oculta .github.
   Asegurate de subir el contenido de la carpeta del proyecto, no el ZIP dentro del repositorio.
5. Pulsa Commit changes.
6. Abre la pestaña Actions. El flujo "Build Minecraft Indev Settings" se ejecutará automáticamente.
7. Si termina con una marca verde, entra en esa ejecución y descarga el Artifact llamado
   MinecraftIndevSettings-26.3.
8. Dentro del ZIP descargado estará el .jar para colocar en la carpeta mods de tu instancia Fabric.

Si la compilación falla:
Abre Actions, entra en la ejecución roja y copia el primer error rojo completo. Enviámelo
para corregir el código. Tener GitHub Actions configurado no garantiza que el código fuente
compile sin errores; el resultado de Actions es quien lo confirma.

ESTADO DEL PROYECTO
Esta es una base inicial. Incluye un botón de configuración, interruptores y una vista previa
dibujada del inventario. Todavía no implementa el inventario real con slots funcionales,
los cambios reales del HUD/neblina ni el cambio de textura/comportamiento del Creeper.
No es todavía un mod completo.

Versiones configuradas según la página de desarrollo de Fabric para 26.3:
Minecraft 26.3, Fabric Loader 0.20.1, Fabric Loom 1.19-SNAPSHOT,
Fabric API 0.166.0+26.3, Java 25. GitHub Actions instala Gradle 9.6.0.
