package mentoring.levelone.javacoreleveltwo.regex.model.logResources;

import mentoring.levelone.javacoreleveltwo.regex.util.FormatUtils;

public record HandledComplaintRow(int id, String dateTime, String phoneNumber) implements LogRow {

    @Override
    public String getStringValue() {
        return String.join(FormatUtils.COMMA, String.valueOf(id), dateTime, phoneNumber);
    }
}