require 'calabash-android/calabash_steps'

Then(/^I hide the keyboard$/) do
    hide_soft_keyboard()
    end


Then(/^I press "([^"]*)" button$/) do |arg1|
    tap_when_element_exists("android.widget.Button {text CONTAINS[c] '#{arg1}'}")
    end