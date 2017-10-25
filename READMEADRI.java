    private String encrypt_passwd(EditText passwd) //encrypt passwd in sha1

    {

	//remplace le EditText en param par une String et adapte le code 

        String passwd_tmp = "$123CONSTAT$" + passwd.getText().toString();

        String Hash_passwd = "";

        //encrypt

        if (!passwd.getText().toString().equals(""))

        {

            try

            {

                MessageDigest crypted = MessageDigest.getInstance("SHA-1");

                crypted.reset();

                crypted.update(passwd_tmp.getBytes("UTF-8"));

                Hash_passwd += byte_to_hex(crypted.digest());

                return Hash_passwd;

            } catch (NoSuchAlgorithmException e)

            {

                e.printStackTrace();

            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();

            }

            return Hash_passwd;

        }

        return null;

    }



    private String byte_to_hex(final byte[] hash)

    {

        Formatter form = new Formatter();

        for (Byte b : hash)

        {

            form.format("%02x", b);

        }

        String tmp = form.toString();

        form.close();

        return tmp;

    }

private boolean isEmailValid(String email) //check with regex if email format is valid

    {

        boolean isValid = false;



        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        CharSequence inputStr = email;



        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches()) {

            isValid = true;

        }

        return isValid;

    }
