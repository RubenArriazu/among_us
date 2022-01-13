# Parameters #####################

# Input
java_file="ud2/maths/e2_solution/CountDivisorsUsingThreads.java"

# Output
program="count_divisor"

##################################

# Cambia a directorio src
cd src

# Compile java class
javac ${java_file}

# Program that performs: "ud3/practica3/e1/Cliente.java" -> "ud3.practica3.e1.Cliente"
java_class=$( sed 's/\//\./g' <<< ${java_file} )
java_class=${java_class::-5}

# Create native image with GraalVM
native-image ${java_class}

# Change the name of the program
mv ${java_class,,} $(echo "../"${program})

# Borra calquier txt generado
rm *.txt
