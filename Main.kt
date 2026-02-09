import java.awt.*
import javax.swing.*
import javax.swing.Timer

fun main() {

    // Create Window
    val frame = JFrame("Hello Beginner")
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    frame.setSize(400, 300)
    frame.layout = BorderLayout()

    // Panel to center components
    val panel = JPanel()
    panel.layout = BoxLayout(panel, BoxLayout.Y_AXIS)
    panel.background = Color.WHITE

    // Text Label
    val label = JLabel("Hello Beginner", SwingConstants.CENTER)
    label.font = Font("Arial", Font.BOLD, 24)
    label.alignmentX = Component.CENTER_ALIGNMENT
    label.foreground = Color(0, 0, 0, 0) // Start transparent

    // Button
    val button = JButton("Click Me")
    button.alignmentX = Component.CENTER_ALIGNMENT

    panel.add(Box.createVerticalGlue())
    panel.add(label)
    panel.add(Box.createRigidArea(Dimension(0, 20)))
    panel.add(button)
    panel.add(Box.createVerticalGlue())

    frame.add(panel, BorderLayout.CENTER)

    frame.isVisible = true

    // Fade-in animation function
    fun fadeIn(newText: String) {

        label.text = newText

        var alpha = 0
        val timer = Timer(30) {

            alpha += 10
            if (alpha >= 255) alpha = 255

            label.foreground = Color(0, 0, 0, alpha)
            label.repaint()

            if (alpha == 255) {
                (it.source as Timer).stop()
            }
        }

        timer.start()
    }

    // Button Click Action
    button.addActionListener {
        fadeIn("Welcome to Kotlin GUI 🎉")
    }
}
