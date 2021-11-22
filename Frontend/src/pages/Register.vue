<template>
<q-page>
    <div class="RegisterPage">
        <h2>Registrieren</h2>
        <div style="max-width: 300px;" class="q-mx-auto">
            <form @submit="validateAndSubmit">
                <form-group name="username">
                    <q-input v-model="username" label="Username" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="firstName">
                    <q-input v-model="firstName" label="Vorname" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="lastName">
                    <q-input v-model="lastName" label="Name" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="eMail">
                    <q-input v-model="email" label="E-Mail" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="password">
                    <q-input v-model="password" type="password" label="Passwort" slot-scope="{attrs}" v-bind="attrs" />
                </form-group>
            </form>
        </div>
        <q-btn class="RegisterButton" color="black" style="margin-right: 10px;" label="Zurück" unelevated to="/Login"/>
        <q-btn class="RegisterButton" color="black" label="Registrieren" @click="validateAndSubmit" />
    </div>

</q-page>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import { Notify } from 'quasar'

export default {
    name: 'Register',
    data() {
        return {
            username: "",
            firstName: "",
            lastName: "",
            email: "",
            password: "",
        }
    },

    methods: {
        async validateAndSubmit(){
            let res = await axios.post("/user", {
                username: this.username,
                firstname: this.firstname,
                lastname: this.lastname,
                email: this.email,
                password: this.password,
            })
            this.$router.push('/user')  
        }
    }
}
</script>

<style>
.RegisterPage {
    text-align: center;
    position: fixed;
    right: 0%;
    width: 100%;
}
.RegisterButton{
    margin-top: 20px;
}
</style>
