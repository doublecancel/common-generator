class Main {

    static void main(args) {
        println('abc')
        read()
    }

    def static read(){


        def properties = new Properties()
        def file = new File("config.properties")
        properties.load(file.newInputStream())

        def ControllerPath = properties.getProperty("ControllerPath")

        println "controllerPath: ${ControllerPath}"


    }


}




